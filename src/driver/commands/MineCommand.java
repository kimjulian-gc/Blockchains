package driver.commands;
import driver.BlockChainDriver;

public class MineCommand implements Command {

  @Override
  public void run(BlockChainDriver instance) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'run'");
  }

  @Override
  public String getDescription() {
    return "discovers the nonce for a given transaction";
  }
  
}
