package track_info;

public class Track_InfoDTO {
	int t_ID, artistID, albumID, genreID;
	String musicName, musicDir, time;

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