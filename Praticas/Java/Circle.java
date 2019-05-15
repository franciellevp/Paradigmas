public class Circle {
   private double x;
   private double y;
   private double r;

   public Circle() {
      x = y = r = 0.0;
      System.out.println("New Circle");
   }

   public Circle(double x, double y, double r) {
      this.x = x;
      this.r = r;
      this.y = y;
      System.out.println("New Construct");
   }

   public void setRadius(double radius){
     this.r = radius;
   }

   public double area() {
      return Math.PI * r * r;
   }
   public static void main(String[] args) {
      Circle c = new Circle();
      System.out.println("Area do circulo: " + c.area());

      c.setRadius(2);

      Circle c2 = new Circle();
      c2.setRadius(5.0);

      Circle c3 = new Circle(2, 3, 0.5);
      System.out.println("Area do circulo3: " + c3.area());
   }
}
