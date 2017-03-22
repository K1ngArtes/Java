import java.awt.Color;

// Test for magic ball
public class LotteryTestC
{
  public static void main(String[] args)
  {
    SpeedController speedController
      = new SpeedController(SpeedController.HALF_SPEED);

    LotteryGUI gui = new LotteryGUI("TV Studio", speedController);

    Game magicGame = new Game("Just a Machine", 49, "Just a rack", 7);

    gui.addGame(magicGame);
    speedController.delay(40);

    magicGame.machineAddBall(new MagicBall(1, Color.RED));
    magicGame.machineAddBall(new MagicBall(10, Color.GREEN));
    magicGame.machineAddBall(new MagicBall(99, Color.PINK));
  }
}
