let selectedArmor = {
    head:null,
    arm:null,
    body:null,
    waist:null,
    leg:null
}


function showDropdown(previewElement) {
    const armorPartName = previewElement.id.replace('Preview', '');
    document.getElementById(armorPartName + "Preview").style.display = 'none';
    document.getElementById(armorPartName + "Dropdown").style.display = 'block';
}

function selectArmor(row) {
    // Read the armor part name from the data attribute
    const armorPartName = row.dataset.armorPartName;
    const armorSkills = row.dataset.armorSkills;

    const cells = row.getElementsByTagName("td");
    const name = cells[0].innerText;
    const defense = cells[1].innerText;
    const skills = cells[2].innerText;
    const resistances = cells[3].innerHTML;

    const parsedSkills = handleSkills(armorSkills);
    const parsedResistances = handleResistances(resistances);

    console.log(parsedSkills);

    selectedArmor[armorPartName] = {
        name: name,
        defense: defense,
        skills: parsedSkills,
        resistances: parsedResistances,
    };

    document.getElementById(armorPartName + '-row').innerHTML = `
        <td>${name}</td>
        <td>${defense}</td>
        <td>${skills}</td>
        ${resistances}
    `;

    document.getElementById(armorPartName + "Dropdown").style.display = 'none';
    document.getElementById(armorPartName + "Preview").style.display = 'block';

    updateOverallStats();

}

function handleSkills(armorSkillsJSON) {
    const armorSkills = JSON.parse(armorSkillsJSON);

    return armorSkills.map(item => ({
        name: item.skill.name,
        level: item.level,
        max: item.skill.max
    }));
}

function handleResistances(resistances) {
    const parser = new DOMParser();
    const doc = parser.parseFromString(resistances, "text/html");

    const elements = doc.querySelectorAll('span > img.elementIcon');
    const parsedResistances = {};

    elements.forEach(img => {
        const elementName = img.alt.replace(":", "");

        const valueElement = img.nextElementSibling;
        const value = valueElement ? parseInt(valueElement.textContent.trim(), 10) : null;

        parsedResistances[elementName] = value;
    });

    return parsedResistances;
}

function updateOverallStats() {
    let totalDefense = 0;
    let fireRes = 0;
    let waterRes = 0;
    let iceRes = 0;
    let thunderRes = 0;
    let dragonRes = 0;
    let overallSkills = {};

    for (const part in selectedArmor) {

        if (selectedArmor[part] &&
        selectedArmor[part].defense !== undefined &&
        selectedArmor[part].resistances["fire"] !== undefined &&
        selectedArmor[part].resistances["water"] !== undefined &&
        selectedArmor[part].resistances["ice"] !== undefined &&
        selectedArmor[part].resistances["thunder"] !== undefined &&
        selectedArmor[part].resistances["dragon"] !== undefined) {
            totalDefense += parseInt(selectedArmor[part].defense);
            fireRes += parseInt(selectedArmor[part].resistances["fire"]);
            waterRes += parseInt(selectedArmor[part].resistances["water"]);
            iceRes += parseInt(selectedArmor[part].resistances["ice"]);
            thunderRes += parseInt(selectedArmor[part].resistances["thunder"]);
            dragonRes += parseInt(selectedArmor[part].resistances["dragon"]);
        }

        if (selectedArmor[part]) {
            for (const skill of selectedArmor[part].skills) {
                if (overallSkills[skill.name] === undefined) {
                    overallSkills[skill.name] = {level: skill.level};
                } else {
                    overallSkills[skill.name].level = Math.min(overallSkills[skill.name].level + skill.level, skill.max);
                }
            }
        }
    }

    let skillsHTML = "";
    for (const skillName in overallSkills) {
        const skill = overallSkills[skillName];
        skillsHTML += `<p>${skillName} Lv ${skill.level}</p>`;
    }

    document.getElementById("overallArmor").innerHTML = `
    <h1>Total Defense: ${totalDefense}</h1>
    <img src="/images/fire.png" alt="fire:"/>
    <h1>${fireRes}</h1>
    <img src="/images/water.png" alt="fire:"/>
    <h1>${waterRes}</h1>
    <img src="/images/ice.png" alt="fire:"/>
    <h1>${iceRes}</h1>
    <img src="/images/thunder.png" alt="fire:"/>
    <h1>${thunderRes}</h1>
    <img src="/images/dragon.png" alt="fire:"/>
    <h1>${dragonRes}</h1>
    ${skillsHTML}
    `;
}

$(document).ready(function () {
    const armorParts = ['head', 'arm', 'body', 'waist', 'leg'];

    armorParts.forEach(function(partName) {
        const tableId = '#' + partName + 'Table';
        const table = $(tableId).DataTable({
            paging: false,
            lengthChange: false,
            searching: true,
            ordering: false,
            info: false,
            autoWidth: false
        });
    });
});