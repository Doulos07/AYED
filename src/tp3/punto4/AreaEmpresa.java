package tp3.punto4;

public class AreaEmpresa {

	private String area;
	private int tardansa_mensaje = 0;
	
	public AreaEmpresa (String area, int tardansa_mensaje) {
		this.area = area;
		this.tardansa_mensaje = tardansa_mensaje;
	}
	
	public AreaEmpresa() {
		// TODO Auto-generated constructor stub
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getTardansa_mensaje() {
		return tardansa_mensaje;
	}

	public void setTardansa_mensaje(int tardansa_mensaje) {
		this.tardansa_mensaje = tardansa_mensaje;
	}
	
	
}
