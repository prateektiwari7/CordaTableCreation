<p align="center">
  <img src="https://www.corda.net/wp-content/uploads/2016/11/fg005_corda_b.png" alt="Corda" width="500">
</p>

#### Creating database from node 
Initialised Nodes in gradle file 
          
          node {
               name "O=PartyA,L=London,C=GB"
               p2pPort 10005
               rpcSettings {
                   address("localhost:10006")
                   adminAddress("localhost:10046")
               }
               rpcUsers = [[ user: "user1", "password": "test", "permissions": ["ALL"]]]
           }
           node {
               name "O=PartyB,L=New York,C=US"
               p2pPort 10008
               rpcSettings {
                   address("localhost:10009")
                   adminAddress("localhost:10049")
               }
               rpcUsers = [[ user: "user1", "password": "test", "permissions": ["ALL"]]]
           }

Create an RPC flow to call from node

            @InitiatingFlow
            @StartableByRPC
            class Initiator : FlowLogic<Unit>() {
                override val progressTracker = ProgressTracker()
                @Suspendable
                override fun call() {
                    val database = serviceHub.cordaService(DatabaseValues::class.java)
                }
            }


    Where DatabaseValues is the corda service. 

DatabaseValues initalised the database queries. And it has one inheritance of DatabaseConnection file

            class DatabaseValues(services: ServiceHub) : DatabaseConnection(services) {
            
        
        
##### RUN node 

Run the RPC call from any node A or B.             


