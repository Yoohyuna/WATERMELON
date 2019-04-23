package allAlbum;

public class albumsDTO {

	private int t_ID;
	private int artistID;
	private int albumID;
	private int genreID;
			
	private String musicName;
	private String genreName;
	private String musicDir;
	private String time;
		
	private String artistName;
	
	private String albumName;
	private String a_imgDir;
	private String a_content;
	
	
	
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public int getGenreID() {
		return genreID;
	}
	public void setGenreID(int genreID) {
		this.genreID = genreID;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public int getT_ID() {
		return t_ID;
	}
	public void setT_ID(int t_ID) {
		this.t_ID = t_ID;
	}
	public int getArtistID() {
		return artistID;
	}
	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}
	public int getAlbumID() {
		return albumID;
	}
	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getMusicDir() {
		return musicDir;
	}
	public void setMusicDir(String musicDir) {
		this.musicDir = musicDir;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getA_imgDir() {
		return a_imgDir;
	}
	public void setA_imgDir(String a_imgDir) {
		this.a_imgDir = a_imgDir;
	}
	
	
	
}
