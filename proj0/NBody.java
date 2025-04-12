public class NBody {
    public static double readRadius(String FileName) {
        In in = new In(FileName);
        int n;
        double radius;
        n = in.readInt();
        radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String FileName) {
        In in = new In(FileName);
        int n;
        double radius;
        n = in.readInt();
        Planet[] p = new Planet[n];
        radius = in.readDouble();
        for(int i = 0; i < n; ++i) {
            double xP, yP, xV, yV, m;
            String img;
            xP = in.readDouble();
            yP = in.readDouble();
            xV = in.readDouble();
            yV = in.readDouble();
            m = in.readDouble();
            img = in.readString();
            p[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return p;
    }

    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();

        for(double t = 0; t < T; t += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for(int i = 0; i < planets.length; ++i) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < planets.length; ++i) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for(int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}