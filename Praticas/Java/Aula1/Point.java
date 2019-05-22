
import static java.lang.Math.*;

public class Point {
   private double x;
   private double y;

   public void Point() {
      x = y = 0.0;
   }

   public void SetPoint(double x, double y) {
      this.x = x;
      this.y = y;
   }
   /*
   um método que desloque as coordenadas de um ponto (x,y) para as coordenadas (x+dx,x+dy), sendo dx e dy argumentos do método
   */
   public void DeslocaXY(Point p, double dx, double dy) {
     p.SetPoint(p.x + dx, p.x + dy);
   }

   // um método que calcule a distância entre 2 pontos (x1,y1) e (x2,y2) segundo o teorema de Pitágoras:
   public double CalculaDistanciaDoisPontos(Point p1, Point p2) {
     double dx = p2.x - p1.x;
     double dy = p2.y - p1.y;
     return Math.sqrt(dx * dx + dy * dy);
   }
}
