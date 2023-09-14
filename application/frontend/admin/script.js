// Function to toggle system status
function toggleSystemStatus() {
    const statusText = document.getElementById('system-status');
    if (statusText.textContent === 'System is online and functioning properly.') {
        statusText.textContent = 'System is currently offline.';
        statusText.style.color = 'red';
    } else {
        statusText.textContent = 'System is online and functioning properly.';
        statusText.style.color = 'black';
    }
}

// Function to handle menu button clicks
function handleMenuButtonClick(buttonId) {
    switch (buttonId) {
        case 'add-vendor-button':
            window.location.href = 'add_vendor.html';
            break;
        case 'view-vendor-button':
            window.location.href = 'view_vendor.html';
            break;
        case 'view-registrations-button':
            window.location.href = 'view_registrations.html';
            break;
        default:
            break;
    }
}


// Function to fetch vendor data from the JSON file
async function fetchVendorData() {
    try {
        const response = await fetch('vendors.json'); // Replace 'vendors.json' with the correct path to your JSON file
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching data:', error);
        return [];
    }
}

// Function to populate the vendor table
async function populateVendorTable() {
    const vendorTableBody = document.getElementById('vendor-table-body');
    const vendorData = await fetchVendorData();

    if (vendorData.length === 0) {
        // Handle the case when no data is available
        vendorTableBody.innerHTML = '<tr><td colspan="5">No vendor data available.</td></tr>';
    } else {
        // Populate the table with vendor data
        vendorData.forEach((vendor) => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${vendor.id}</td>
                <td>${vendor.name}</td>
                <td>${vendor.category}</td>
                <td>${vendor.description}</td>
                <td>${vendor.contact}</td>
            `;
            vendorTableBody.appendChild(row);
        });
    }
}

// Call the function to populate the vendor table when the page loads
populateVendorTable();

// Function to fetch registration data from the JSON file
async function fetchRegistrationData() {
    try {
        const response = await fetch('registrations.json'); // Replace 'registrations.json' with the correct path to your JSON file
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching data:', error);
        return [];
    }
}

// Function to populate the registrations table
async function populateRegistrationsTable() {
    const registrationsTableBody = document.getElementById('registrations-table-body');
    const registrationData = await fetchRegistrationData();

    if (registrationData.length === 0) {
        // Handle the case when no data is available
        registrationsTableBody.innerHTML = '<tr><td colspan="6">No registration data available.</td></tr>';
    } else {
        // Populate the table with registration data
        registrationData.forEach((registration) => {
            const row = document.createElement('tr');
            row.innerHTML = `
                        <td>${registration.id}</td>
                        <td>${registration.name}</td>
                        <td>${registration.email}</td>
                        <td>${registration.event}</td>
                        <td>${registration.status}</td>
                        <td>
                            <button onclick="activateRow(this)">Activate</button>
                            <button onclick="deactivateRow(this)">Deactivate</button>
                        </td>
                    `;
            registrationsTableBody.appendChild(row);
        });
    }
}

// Function to activate a row
function activateRow(button) {
    const row = button.closest('tr');
    // Add your logic to update the row's status to 'Active' and style accordingly
    const statusCell = row.querySelector('td:nth-child(5)');
    statusCell.textContent = 'Active';
    statusCell.style.color = 'green';
}

// Function to deactivate a row
function deactivateRow(button) {
    const row = button.closest('tr');
    // Add your logic to update the row's status to 'Inactive' and style accordingly
    const statusCell = row.querySelector('td:nth-child(5)');
    statusCell.textContent = 'Inactive';
    statusCell.style.color = 'red';
}

// Call the function to populate the registrations table when the page loads
populateRegistrationsTable();

document.getElementById('add-vendor-button').addEventListener('click', () => handleMenuButtonClick('add-vendor-button'));
document.getElementById('view-vendor-button').addEventListener('click', () => handleMenuButtonClick('view-vendor-button'));
document.getElementById('view-registrations-button').addEventListener('click', () => handleMenuButtonClick('view-registrations-button'));