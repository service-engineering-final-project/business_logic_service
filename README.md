# Business Logic Service (REST)

The **business logic service** is the service that deals with the manipulation of data in order to take decisions. It receives requests from the **process centric service**, then gets data from the **storage data service** to compute results to send back to the dispatcher.

| resource | link |
|----------|------|
| API documentation | http://docs.businesslogicservice1.apiary.io/ |
| Heroku base URL | https://business-logic-service-ar.herokuapp.com/rest/ |

### How to run it
Since the server is already deployed on Heroku, it is only needed to go to the Heroku base URL. However, you can also deploy again the server on Heroku via ant.

**Optional**: If you want to try the server locally, you can follow the steps below:
* **Clone** the repo: `git clone https://github.com/service-engineering-final-project/business_logic_service.git`;
* **Navigate** into the project folder: `cd business_logic_service`;
* **Install** the packages needed: `ant install`;
* **Run** the server using ant: `ant execute.server`.