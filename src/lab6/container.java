package lab6;

public class container implements Comparable<container> {
private String UUID;
private String SHORT_NAME;
private String LONG_NAME;

public String getid ( ) {
	return UUID;
}
public String getSHORT_NAME ( ) {
	return SHORT_NAME;
}
public String getLONG_NAME ( ) {
	return LONG_NAME;
}
 public void setid (String UUID ) {
	this.UUID=UUID;
}
 public void setSHORT_NAME (String SHORT_NAME ) {
	this.SHORT_NAME=SHORT_NAME;
}
 public void setLONG_NAME (String LONG_NAME ) {
	this.LONG_NAME=LONG_NAME;
}

public String toString() {
	return "<CONTAINER UUID =" + this.getid() +">\n" 
			+    "<SHORT-NAME>" + this.getSHORT_NAME() + "</SHORT-NAME>"
			+    "<LONG-NAME>" + this.getLONG_NAME()   + "</LONG-NAME>"
			+"</CONTAINER>";
}

public int compareTo (container o) {
	if (this.getLONG_NAME().charAt(0)>o.getLONG_NAME().charAt(0))
		return 1;
	else if (this.getLONG_NAME().charAt(0)<o.getLONG_NAME().charAt(0))
		return -1;
	else return 0;
}
}
