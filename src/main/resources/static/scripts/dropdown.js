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

    const cells = row.getElementsByTagName("td");
    const name = cells[0].innerText;
    const defense = cells[1].innerText;
    const skills = cells[2].innerText;
    const resistances = cells[3].innerHTML;

    selectedArmor[armorPartName] = {
        name: name,
        defense: defense,
        skills: skills,
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

function updateOverallStats() {
    let totalDefense = 0;

    for (const part in selectedArmor) {
        if (selectedArmor[part] && selectedArmor[part].defense) {
            totalDefense += parseInt(selectedArmor[part].defense);
        }
    }

    document.getElementById("overallArmor").innerHTML = `
    <h1>Total Defense: ${totalDefense}</h1>
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