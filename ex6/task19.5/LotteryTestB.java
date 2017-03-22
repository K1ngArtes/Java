// Test the Dramatic machine
public class LotteryTestB
{
  public static void main(String args[])
  {
    SpeedController speedController
      = new SpeedController(SpeedController.HALF_SPEED);

    LotteryGUI gui = new LotteryGUI("TV Studio", speedController);

    // Create a worker
    Worker worker = new Worker("Arthur");
    gui.addPerson(worker);

    // Create a game
    Game dramaticGame = new DramaticGame("Dramatic Machine", 49,
                                         "Just a rack", 7);
    gui.addGame(dramaticGame);
    speedController.delay(40);

    // Fill a machine
    worker.fillMachine(dramaticGame);
    speedController.delay(40);

    // Eject balls
    for (int count = 1; count <= dramaticGame.getRackSize(); count ++)
    {
      dramaticGame.ejectBall();
      speedController.delay(10);
    }
  }
}
