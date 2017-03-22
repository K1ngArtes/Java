// Representation of the game with dramatic machine being used
public class DramaticGame extends Game
{
  public DramaticGame(String machineName, int machineSize,
                      String rackName, int rackSize)
  {
    super(machineName, machineSize, rackName, rackSize);
  }

  // Create and return a machine, which is a dramatic machine
  @Override
  public Machine makeMachine(String machineName, int machineSize)
  {
    return new DramaticMachine(machineName, machineSize);
  }
}
