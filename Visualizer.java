// To test, before running, do "python -m SimpleHTTPServer" from this directory
// URL params don't work from file:/// urls; this is an easy way to start a
// local server


// Browser opening code courtesy of
// https://stackoverflow.com/a/17950164/2718315
import java.awt.Desktop;
import java.net.URI;


int getZoom() { return zoom; }


int getCSELatDegrees() { return CSELatDegrees; }
int getCSELatSeconds() { return CSELatSeconds; }
int getCSELongDegrees() { return CSELongDegrees; }
int getCSELongSeconds() { return CSELongSeconds; }
String getCSELabel() { return CSELabel; }

int getDestLatDegrees() { return destLatDegrees; }
int getDestLatSeconds() { return destLatSeconds; }
int getDestLongDegrees() { return destLongDegrees; }
int getDestLongSeconds() { return destLongSeconds; }
String getDestLabel() { return destLabel; }

boolean showCSE = false;
if(getCSELatDegrees() != 0 &&
   getCSELatSeconds() != 0 &&
   getCSELongDegrees() != 0 &&
   getCSELongSeconds() != 0) {
  showCSE = true;
}

boolean showDest = false;
if(getDestLatDegrees() != 0 &&
   getDestLongDegrees() != 0) {
  showDest = true;
}

int zoomMap = 2;
if (showCSE) {
  zoomMap = 5;
}
if (showDest) {
  zoomMap = getZoom();
}

String label = getDestLabel();


String url =
/* "http://localhost:8000/maps.html?" + */
  "http://cseweb.ucsd.edu/classes/fa18/cse8a/maps.html?" +
  "latAdeg=" + getCSELatDegrees() + "&" +
  "latAsec=" + getCSELatSeconds() + "&" +
  "longAdeg=" + getCSELongDegrees() + "&" +
  "longAsec=" + getCSELongSeconds() + "&" +
  "latBdeg=" + getDestLatDegrees() + "&" +
  "latBsec=" + getDestLatSeconds() + "&" +
  "longBdeg=" + getDestLongDegrees() + "&" +
  "longBsec=" + getDestLongSeconds() + "&" +
  "label=" + label + "&" +
  "zoom=" + zoomMap + "&" +
  "showCSE=" + showCSE + "&" +
  "showDest=" + showDest + "&";

System.out.println(new URI(url));

if (Desktop.isDesktopSupported()) {
  Desktop.getDesktop().browse(new URI(url));
} else {
  System.out.println("Your system may not be supported, try running on the lab machines, or copy/paste this URL into your browser: \n" + url);
}
