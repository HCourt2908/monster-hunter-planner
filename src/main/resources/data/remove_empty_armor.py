import json

# Step 1: Load JSON data from a file
with open("hr/armor_waist_hr.json", "r", encoding="utf-8") as infile:
    data = json.load(infile)

# Step 2: Filter out objects with an empty "name" field
cleaned_data = [obj for obj in data if obj.get("name", None) != ""]

# Step 3: Write cleaned data to a new file
with open("hr/armor_waist_hr.json", "w", encoding="utf-8") as outfile:
    json.dump(cleaned_data, outfile, indent=2)
