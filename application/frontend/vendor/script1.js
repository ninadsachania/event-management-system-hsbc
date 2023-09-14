document.addEventListener("DOMContentLoaded", function () {
    // Load JSON data
    fetch("user_requests.json")
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector("tbody");

            data.forEach(request => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${request.userId}</td>
                    <td>${request.eventType}</td>
                    <td>${request.eventDate}</td>
                    <td><a class="create-quotation" data-userid="${request.userId}" href="#">Create Quotation</a></td>
                `;
                tableBody.appendChild(row);
            });

            /// Add click event listeners to "Create Quotation" links
            const createQuotationLinks = document.querySelectorAll(".create-quotation");
            createQuotationLinks.forEach(link => {
                link.addEventListener("click", function (event) {
                    event.preventDefault();
                    const userId = this.getAttribute("data-userid");
                    // Redirect to the create quotation page with the user ID as a query parameter
                    window.location.href = `create_quotation.html?userId=${userId}`;
                });
            });
        })
        .catch(error => console.error("Error fetching JSON data:", error));
});

// JavaScript code to retrieve the user ID from the query parameter
const urlParams = new URLSearchParams(window.location.search);
const userId = urlParams.get('userId');

// Populate the user ID input field
document.getElementById('userId').value = userId;

// Handle form submission (you can add more logic here)
document.getElementById('quotationForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const quotationAmount = document.getElementById('quotationAmount').value;
    // Process the quotation data, possibly sending it to a server or storing it locally
    // You can add more logic here based on your requirements
    alert(`Quotation for User ID ${userId} with amount ${quotationAmount} submitted.`);
});
