// Test for magic worker
public class LotteryTestD
{
  public static void main(String args[])
  {
    SpeedController speedController
      = new SpeedController(SpeedController.HALF_SPEED);

    LotteryGUI gui = new LotteryGUI("TV Studio", speedController);

    // Create a worker
    Worker worker = new MagicWorker("Arthur");
    Worker worker2 = new MagicWorker("Bob");
    gui.addPerson(worker);
    gui.addPerson(worker2);

    // Create a game
    Game magicGame = new Game("Just a Machine", 49,
                              "Magic rack", 7);

    Game magicGame2 = new Game("Just a Machine", 49,
                              "Magic rack 2", 7);
    gui.addGame(magicGame);
    gui.addGame(magicGame2);
    speedController.delay(40);

    // Fill a machine
    worker.fillMachine(magicGame);
    speedController.delay(40);
    worker2.fillMachine(magicGame2);
    speedController.delay(40);

    for (int count = 1; count <= magicGame.getRackSize(); count ++)
    {
      magicGame.ejectBall();
      magicGame2.ejectBall();
      speedController.delay(10);
    }
  }
}
