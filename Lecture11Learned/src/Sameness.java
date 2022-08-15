import tester.*;

// to represents an Author
class Author {
  String first;
  String last;

  Author(String first, String last) {
    this.first = first;
    this.last = last;
  }

  // tests if two Authors are the same
  boolean sameAuthor(Author other) {
    return this.first.equals(other.first) && this.last.equals(other.last);
  }
}

// to represent a book
class Book {
  String title;
  Author author;

  Book(String title, Author author) {
    this.title = title;
    this.author = author;
  }

  // tests if two books are the same
  boolean sameBook(Book other) {
    return this.title.equals(other.title) && this.author.sameAuthor(other.author);
  }
}

// to represent a Cartesian point
class CartPt {
  int x;
  int y;

  CartPt(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // tests if two CartPts are the same
  boolean samePoint(CartPt other) {
    return this.x == other.x && this.y == other.y;
  }
}

interface IShape {
  // tests if two shapes are the same
  boolean sameShape(IShape other);
  // is this shape a Circle?
  boolean isCircle();
  // is this shape a Rect?
  boolean isRect();
  // is this shape a Square?
  boolean isSquare();
}

class Circle implements IShape {
  int x, y;
  int radius;

  Circle(int x, int y, int radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  // tests if two Circles are the same
  boolean sameCircle(Circle other) {
    return this.x == other.x && this.y == other.y && this.radius == other.radius;
  }

  // tests if two shapes are the same
  public boolean sameShape(IShape other) {
    if (other.isCircle()) {
      return this.sameCircle((Circle) other); // allowed to cast because we know this is a circle
    }
    else {
      return false;
    }
  }
  
  public boolean isCircle(){
    return true;
  }
  
  public boolean isRect() {
    return false;
  }
  
  public boolean isSquare() {
    return false;
  }
}

class Rect implements IShape {
  int x, y;
  int w, h;

  Rect(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  // tests if two Rectangles are the same
  boolean sameRect(Rect other) {
    return this.x == other.x && this.y == other.y && this.w == other.w && this.h == other.h;
  }

  // tests if two shapes are the same
  public boolean sameShape(IShape other) {
    if (other.isRect()) {
      return this.sameRect((Rect) other); // allowed to cast because we know this is a rect
    }
    else {
      return false;
    }
  }
  
  public boolean isCircle(){
    return false;
  }
  
  public boolean isRect() {
    return true;
  }
  
  public boolean isSquare() {
    return false;
  }
}

class Square extends Rect {
  Square(int x, int y, int w) {
    super(x, y, w, w);
  }

  // tests if a square if the same as another square
  boolean sameSquare(Square other) {
    return this.x == other.x && this.y == other.y && this.w == other.w;
  }

  // tests if two shapes are the same
  public boolean sameShape(IShape other) {
    if (other.isSquare()) {
      return this.sameSquare((Square) other);
    }
    else {
      return false;
    }
  }
  
  public boolean isCircle(){
    return false;
  }
  
  public boolean isRect() {
    return false;
  }
  
  public boolean isSquare() {
    return true;
  }
}

class ExamplesSameness {
  ExamplesSameness() {
  }

  Author Tim1 = new Author("Tim", "Jim");
  Author Tim2 = new Author("Tim", "Jim");
  Author Jim = new Author("Jim", "Tim"); // different name

  Book B1 = new Book("Title", Tim1);
  Book B2 = new Book("Title", Tim2);
  Book B3 = new Book("Title", Jim); // different author
  Book B4 = new Book("Other Title", Tim1); // different title

  CartPt P1 = new CartPt(1, 2);
  CartPt P2 = new CartPt(1, 2);
  CartPt P3 = new CartPt(1, 1); // different points

  // tests sameAuthor method
  void testSameAuthor(Tester t) {
    t.checkExpect(Tim1.sameAuthor(Tim2), true);
    t.checkExpect(Tim1.sameAuthor(Jim), false);
    t.checkExpect(Tim2.sameAuthor(Tim1), true);
  }

  // tests sameBook method
  void testSameBook(Tester t) {
    t.checkExpect(B1.sameBook(B2), true);
    t.checkExpect(B2.sameBook(B1), true);
    t.checkExpect(B3.sameBook(B2), false);
    t.checkExpect(B4.sameBook(B3), false);
  }

  // tests samePoint method
  void testSamePoint(Tester t) {
    t.checkExpect(P1.samePoint(P2), true);
    t.checkExpect(P1.samePoint(P3), false);
  }

  // In test method in an Examples class
  Circle c1 = new Circle(3, 4, 5);
  Circle c2 = new Circle(4, 5, 6);
  Circle c3 = new Circle(3, 4, 5);
  Rect r1 = new Rect(3, 4, 5, 5);
  Rect r2 = new Rect(4, 5, 6, 7);
  Rect r3 = new Rect(3, 4, 5, 5);
  // In test method in an Examples class
  Square s1 = new Square(3, 4, 5);
  Square s2 = new Square(4, 5, 6);
  Square s3 = new Square(3, 4, 5);

  // tests sameCircle and sameRect methods
  void testShapes(Tester t) {
    t.checkExpect(c1.sameCircle(c2), false);
    t.checkExpect(c2.sameCircle(c1), false);
    t.checkExpect(c1.sameCircle(c3), true);
    t.checkExpect(c3.sameCircle(c1), true);

    t.checkExpect(r1.sameRect(r2), false);
    t.checkExpect(r2.sameRect(r1), false);
    t.checkExpect(r1.sameRect(r3), true);
    t.checkExpect(r3.sameRect(r1), true);
  }

  // In the Examples class
  void testSameShape(Tester t) {
    t.checkExpect(c1.sameShape(c3), true); // works
    t.checkExpect(c1.sameShape(c2), false); // works
    t.checkExpect(r1.sameShape(r3), true); // works
    t.checkExpect(r1.sameShape(r2), false); // works
    t.checkExpect(c1.sameShape(r1), false); // CRASH! with a ClassCastException
  }

  // basic checks comparing two Squares should work
  void testSameSquare(Tester t){
    t.checkExpect(s1.sameShape(s2), false);
    t.checkExpect(s2.sameShape(s1), false);
    t.checkExpect(s1.sameShape(s3), true);
    t.checkExpect(s3.sameShape(s1),true);
 // Comparing a Square with a Rect of a different size
    t.checkExpect(s1.sameShape(r2), false); // Good
    t.checkExpect(r2.sameShape(s1), false);// Good
    // Comparing a Square with a Rect of the same size
    t.checkExpect(s1.sameShape(r1), false); // Good
    t.checkExpect(r1.sameShape(s1), false);  // Not so good

  }

}
