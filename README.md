# Railway-Ticket-Booking-System
This System is used for booking tickets,  a QrCode is generated for a ticket that is purchased. This QrCode can then be validated by a scanner.
* User registers with the webApp.
* User is provided with a e-wallet.
* User selects the source and destination along with journey type and a ticket is booked for him.

## Spring MVC things!
* One to One mapping between customer and wallet.
* One to Many mapping between customer and ticket.
* QrCode Generation API is used for generating ticket.
* FareDetails table to fetch fare for a journey.(Made use of sql call)
* Hibernate mapping for saving and updating customer,wallet and ticket.
