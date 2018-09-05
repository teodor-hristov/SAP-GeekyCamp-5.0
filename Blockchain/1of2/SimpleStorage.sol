pragma solidity ^0.4.0;



contract SimpleStorage {
    uint storedData;
    address owner = msg.sender;
    uint counter = 0;

    function set(uint x) public {
        require(owner == msg.sender);
        counteIncrement();
        storedData = x;
        
    }

    function get() public constant returns (uint) {
        return storedData;
    }
    function counteIncrement() private {
        uint256 c =  counter + 1;
        require(c >= counter);
        counter = c;
    }
    function counterGet() public constant returns (uint){
        return counter;
    }
}
