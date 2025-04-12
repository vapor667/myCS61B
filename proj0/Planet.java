public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.pow(dx * dx + dy * dy, 0.5);
    }

    public double calcForceExertedBy(Planet p) {
        double d = this.calcDistance(p);
        return G * mass * p.mass / (d * d);
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - xxPos;
        double d = this.calcDistance(p);
        double F = this.calcForceExertedBy(p);
        return F * dx / d;
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - yyPos;
        double d = this.calcDistance(p);
        double F = this.calcForceExertedBy(p);
        return F * dy / d;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double Fx = 0;
        for(Planet i : p) {
            if (!this.equals(i)) {
                Fx += calcForceExertedByX(i);
            }
        }
        return Fx;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double Fy = 0;
        for(Planet i : p) {
            if (!this.equals(i)) {
                Fy += calcForceExertedByY(i);
            }
        }
        return Fy;
    }

    public void update(double dt, double Fx, double Fy) {
        double ax = Fx / mass;
        double ay = Fy / mass;
        xxVel += ax * dt;
        yyVel += ay * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
        return;
    }
}