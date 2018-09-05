pragma solidity 0.4.24;
import "./CorgiToken.sol";
contract DDNS {
    uint constant ETH_CONSTANT = 1000000000000000000;
   struct Domain{
       address owner;
       string ip;
   }
   
   mapping(string => Domain) domains;
   mapping(string => bool) domainStatus;
   address minter;
   uint256 coins;
   
   constructor() public payable {
       minter = msg.sender;
       coins = msg.value;
   }
    
    function buyDomain(string domain, string ip) public payable { //the 'payable' modifier is needed in order to receive ETH. Read the docs for further info.
        require(!domainStatus[domain],"This domain is not available.");
        require(msg.value <= ETH_CONSTANT, "No");
        coins+=msg.value;
        
        domains[domain].owner = msg.sender;
        domains[domain].ip = ip;
        domainStatus[domain] = true;
        
        
    }
    
    function setIP(string domain, string ip) public {
        address currentSender = msg.sender;
        require(domains[domain].owner == currentSender, "Can't touch this");
        domains[domain].ip = ip;
        
    }
    
    function getIP(string domain) public returns (string) {
        if(domains[domain].owner != msg.sender){
            return;
        }
        else{
            return domains[domain].ip;
        }
    }
    
    function currentMoney() public view returns (uint){
        return coins;
        
    }
    
    function withdraw(uint value) public payable {
        require(minter == msg.sender,"Access denied!");
        require(coins != 0, "No money, go to work you little sh*t!");
        require(coins >= value, "Don't have enough money");
        coins -= value;
        msg.sender.transfer(coins);
        
    }
    
    //maybe functionality? Your choice!
}
