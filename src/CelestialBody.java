

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

	private static int getCount(){
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

	/**
	* retrieves the X Position of a CelestialBody
	* @return value of X Position
	*/
	public double getX() {
		// TODO: complete method
		return myXPos;
	}

	/**
	 * retrieves the Y Position of a CelestialBody
	 * @return value of Y Position
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}

	/**
	 * retrieves the X Velocity of a CelestialBody
	 * @return value of X Velocity
	 */
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

	/**
	 * retrieves the Mass of a CelestialBody
	 * @return value of Mass
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}

	/**
	 * retrieves the file name of a CelestialBody
	 * @return value of file name
	 */
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
		double xDist = b.myXPos - myXPos;
		double yDist = b.myYPos - myYPos;
		return Math.sqrt((xDist*xDist)+(yDist*yDist));
	}

	/**
	 * Return the force exerted on this body by another
	 * @param b the other body to which force is calculated
	 * @return force exerted by this body and b
	 */
	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		double g = (6.67*1e-11);
		double distSq = calcDistance(b)*calcDistance(b);
		double mass = b.myMass * myMass;
		return g*mass/distSq;
	}
	/**
	 * Return the X force component exerted on this body by another
	 * @param b the other body to which force is calculated
	 * @return X force component exerted by this body and b
	 */
	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		double xDist = b.myXPos - myXPos;
		double force = calcForceExertedBy(b);
		double r = calcDistance(b);
		return force*xDist/r;
	}

	/**
	 * Return the Y force component exerted on this body by another
	 * @param b the other body to which force is calculated
	 * @return Y force component exerted by this body and b
	 */
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		double yDist = b.myYPos - myYPos;
		double force = calcForceExertedBy(b);
		double r = calcDistance(b);
		return force*yDist/r;
	}
	/**
	 * Return the net X force components exerted on this body by another
	 * @param bodies the other body to which force is calculated
	 * @return sum of the X force components exerted by this body and b
	 */
	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double sum = 0.0;
		for(CelestialBody b : bodies){
			if( ! b.equals(this)){
				sum+=calcForceExertedByX(b);
			}
		}
		return sum;
	}
	/**
	 * Return the net Y force components exerted on this body by another
	 * @param bodies the other body to which force is calculated
	 * @return sum of the Y force components exerted by this body and b
	 */
	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		for(CelestialBody b : bodies){
			if( ! b.equals(this)){
				sum+=calcForceExertedByY(b);
			}
		}
		return sum;
	}

	/**
	 * Update the parameters of a CelestialBody object
	 * @param deltaT for time elapsed step
	 * @param xforce the xforce value from calcNetForceExertedByX
	 * @param yforce the yforce value from calcNetForceExertedByX
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method

		double aX = xforce/myMass;
		double aY = yforce/myMass;
		double nvx = myXVel + deltaT*aX;
		double nvy = myYVel + deltaT*aY;
		double nx = myXPos + deltaT*nvx;
		double ny = myYPos + deltaT*nvy;

		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
