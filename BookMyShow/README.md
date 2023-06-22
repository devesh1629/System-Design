Low Level Design for BookMyShow

Movie has id, name and duration
Seat has id, row and SeatCategory
Screen has id and List of Seat
Show has id, Movie, Screen, startTime, List of bookedSeats
Theatre has id, City, List of Show, List of Screen
Booking has Payment, Show, List of Seat booked

MovieControllers adds Movie, gets Movie by name, gets Movie by City
TheatreController adds Theatre, gets all Show of Movie m in City c

For Booking, user should provide Movie, City - user will be provided with List of Show. 
He will provide Payment to confirm booking
