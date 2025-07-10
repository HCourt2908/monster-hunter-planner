import json

def simplify_armor_file(input_filename, output_filename):
    with open(input_filename, 'r', encoding='utf-8') as f:
        all_armors = json.load(f)

    simplified_armors = []

    for armor in all_armors:
        raw = armor.get('raw_data', {})

        simplified = {
            'armor_index': armor.get('armor_index'),
            'name': armor.get('name'),
            'skills': armor.get('skills'),
            'defense': armor.get('defense'),
            'resistances': armor.get('resistances'),
            'rare': raw.get('rare'),
            'series': raw.get('series'),
            'sexual_equipable': raw.get('sexual_equipable'),
            'buildup_table': raw.get('buildup_table'),
            'decorations_num_list': raw.get('decorations_num_list')
        }

        simplified_armors.append(simplified)

    with open(output_filename, 'w', encoding='utf-8') as f:
        json.dump(simplified_armors, f, indent=2, ensure_ascii=False)

    print(f"Simplified armor data saved to {output_filename}")


if __name__ == "__main__":
    simplify_armor_file("hr/armor_waist_hr.json", "hr/armor_waist_hr.json")
