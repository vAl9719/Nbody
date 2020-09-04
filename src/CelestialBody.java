

/**
 * Celestial Body class for NBody
 * @author ola
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	private static int ourBodyCount;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;

		ourBodyCount += 1;
	}

	public static int getCount(){
		return ourBodyCount;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		// TODO: complete constructor
		myXPos = b.getX();
		myYPos = b.getY();
		myXVel = b.getXVel();
		myYVel = b.getYVel();
		myMass = b.getMass();
		myFileName = b.getName();

		ourBodyCount += 1;
	}

	public double getX() {
		// TODO: complete method
		return myXPos;
	}
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		double xDist = Math.abs(b.myXPos - myXPos);
		double yDist = Math.abs(b.myYPos - myXPos);
		return Math.sqrt((xDist*xDist)+(yDist*yDist));
	}

	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		return 0.0;
	}

	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		return 0.0;
	}
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		return 0.0;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double sum = 0.0;
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		return sum;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
