# noted-api
a backend written with springboot framework to handle api requests for a todo list app

This project is created due to an assignment I had received from Appcent company as an internship offer.
Its a simple backend program that responds to requests from my frontend web app.Its basic purpose is to allow users to
authenticate and create/update their own todo lists freely.

Here is a link to frontend side that was coded with angular:

https://github.com/aEmreAydemir/noted-web

If you want to use this app locally, dont forget to change cross origin annottation from 
@CrossOrigin(origins = "https://noted-web-app.herokuapp.com/", maxAge = 3600) to "localhost:/4200"
which is commented above.

But if you want to test the project without running it on your local, go to this website that I have deployed my frontend:
https://noted-web-app.herokuapp.com/ . Frontend is quite simple atm.
