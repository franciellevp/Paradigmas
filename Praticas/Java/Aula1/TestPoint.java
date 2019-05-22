public class TestPoint {
   public static void main(String[] args) {
      Point p1 = new Point();
      Point p2 = new Point();
      p1.SetPoint(2.0, 43.6);
      p2.SetPoint(6.0, 8.9);
      double distancia = p1.CalculaDistanciaDoisPontos(p1, p2);
      System.out.println("Dist " + distancia);
   }
}
