package single;

public class SingleDTO {

	private int t_ID;  		// 트랙아이디
	private int artistID;  		// 아티스트아이디
	private int albumID;  		// 앨범아이디
	private int genreID;  		// 장르아이디
	private String musicName; 	// 노래제목
	private String musicDir; 	// 노래경로
	private String time; 	// 시간
	private String albumName;
	private String a_content;
	private String a_imgDir;
	private String artistName;
	
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
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public String getA_imgDir() {
		return a_imgDir;
	}
	public void setA_imgDir(String a_imgDir) {
		this.a_imgDir = a_imgDir;
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
	public int getGenreID() {
		return genreID;
	}
	public void setGenreID(int genreID) {
		this.genreID = genreID;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


	
}
