document.addEventListener('DOMContentLoaded', function () {
    // Get the "View Profile" button element by its id
    var viewProfileButton = document.getElementById('view-profile-button');

    // Add a click event listener to the button
    viewProfileButton.addEventListener('click', function (event) {
        // Prevent the default behavior of the anchor tag (preventing the page from reloading)
        event.preventDefault();

        // Redirect the user to the "view_profile.html" page
        window.location.href = 'view_profile.html';
    });
});

document.addEventListener('DOMContentLoaded', function () {
    // Get the "Change Password" button element by its id
    var changePasswordButton = document.getElementById('change-password-button');

    // Add a click event listener to the button
    changePasswordButton.addEventListener('click', function () {
        // Redirect the user to the "change_password.html" page
        window.location.href = 'change_password.html';
    });
});

document.addEventListener('DOMContentLoaded', function () {
    // Get the "Send Plan Request" button element by its id
    var sendRequestButton = document.getElementById('send-request-button');

    // Add a click event listener to the button
    sendRequestButton.addEventListener('click', function () {
        // Redirect the user to the "send_plan_request.html" page
        window.location.href = 'send_plan_request.html';
    });
});

// viewquotations.js

document.addEventListener('DOMContentLoaded', function () {
    // Fetch data from a JSON file (replace 'data.json' with your actual JSON file)
    fetch('data.json')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector('tbody');

            // Loop through the data and create rows in the table
            data.forEach(quotation => {
                const row = document.createElement('tr');

                // Loop through the headers and create cells based on header names
                const headers = ["Vendor Id", "Vendor Name", "Quotation Amount", "User Id", "Plan Request Id", "Status", "Package"];
                headers.forEach(header => {
                    const cell = document.createElement('td');
                    cell.textContent = quotation[header] || '';
                    row.appendChild(cell);
                });

                const actionCell = document.createElement('td');
                const acceptButton = document.createElement('button');
                acceptButton.textContent = 'Accept';
                acceptButton.addEventListener('click', () => {
                    // Handle accept action here
                    alert(`Accepted quotation from ${quotation["Vendor Name"]}`);
                });
                const rejectButton = document.createElement('button');
                rejectButton.textContent = 'Reject';
                rejectButton.addEventListener('click', () => {
                    // Handle reject action here
                    alert(`Rejected quotation from ${quotation["Vendor Name"]}`);
                });
                actionCell.appendChild(acceptButton);
                actionCell.appendChild(rejectButton);
                row.appendChild(actionCell);

                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
});


