#Homework (1/2)
• Create a contract, that:
• Holds a counter state variable (uint)
• Has a function that will increment this counter by 1 only if called by the
contract owner. If not, it should raise an exception.
• Has a getter for the counter
• Has overflow protection (don’t hardcode anything related to the type
please)
#Homework (2/2)
• Create a DDNS contract (Decentralized Domain Name System),
that:
• Has a method to buy a domain name (string type). The price is 1 ETH. A
domain cannot be bought if it is already owned by someone
• Look up how to send & accept ETH payments using smart contracts (or ask me if
you’re stuck)
• Has a method to change/set the IP of a domain to a given value. Can only
be called by the domain owner. For testing purposes, you can use regular
integers instead of IP addresses.
• Has a method to get the IP of a given domain.
• Has a method that allows the contract owner to withdraw money
collected in the contract’s balance from domain purchases
• For simplicity, domains cannot expire once they have been purchased.