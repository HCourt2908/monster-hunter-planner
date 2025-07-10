import json
import os

def split_armor_file(input_filename):
    with open(input_filename, 'r', encoding='utf-8') as f:
        all_armors = json.load(f)

    lr_armors = []
    hr_armors = []

    for armor in all_armors:
        raw_data = armor.get('raw_data', {})
        rare = raw_data.get('rare')

        if rare is None:
            print(f"Warning: armor missing rare value: {armor.get('name')}")
            continue

        if 1 <= rare <= 3:
            lr_armors.append(armor)
        elif 4 <= rare <= 7:
            hr_armors.append(armor)
        else:
            print(f"Warning: armor rare value outside expected range: {rare} for {armor.get('name')}")

    base_name = input_filename.rsplit('.', 1)[0]
    lr_filename = f"{base_name}_lr.json"
    hr_filename = f"{base_name}_hr.json"

    with open(lr_filename, 'w', encoding='utf-8') as f:
        json.dump(lr_armors, f, indent=2, ensure_ascii=False)

    with open(hr_filename, 'w', encoding='utf-8') as f:
        json.dump(hr_armors, f, indent=2, ensure_ascii=False)

    print(f"Done! LR armors: {len(lr_armors)}, HR armors: {len(hr_armors)}")


if __name__ == "__main__":
    split_armor_file("armor_waist.json")
