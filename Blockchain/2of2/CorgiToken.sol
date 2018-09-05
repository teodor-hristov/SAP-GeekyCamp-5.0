pragma solidity ^0.4.17;

contract CorgiToken {
    string  public name = "Corgi Token";
    string  public symbol = "CORGI";
    string  public standard = "Some shitty standard";
    uint8   public decimals = 90;
    uint256 public totalSupply;

    mapping(address => uint256) public bank;
    mapping(address => mapping(address => uint256)) public allowance;

    event Transfer(
        address indexed from,
        address indexed to,
        uint256 value
    );

    event Approval(
        address indexed owner,
        address indexed person,
        uint256 value
    );

    function CorgiToken (uint256 supply) public {
        bank[msg.sender] = supply;
        totalSupply = supply;
    }

    function transfer(address to, uint256 value) public returns (bool success) {
        require(bank[msg.sender] >= value);

        bank[msg.sender] -= value;
        bank[to] += value;

        Transfer(msg.sender, to, value);

        return true;
    }

    function approve(address spender, uint256 value) public returns (bool success) {
        allowance[msg.sender][spender] = value;

        Approval(msg.sender, spender, value);

        return true;
    }

    function transferFrom(address from, address to, uint256 value) public returns (bool success) {
        require(value <= bank[from]);
        require(value <= allowance[from][msg.sender]);

        bank[from] -= value;
        bank[to] += value;
        allowance[from][msg.sender] -= value;

        Transfer(from, to, value);

        return true;
    }
}
