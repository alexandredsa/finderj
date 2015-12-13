package br.com.t1tecnologia.finderj.enums;

public enum FileSaverPath {
	PATH_IMAGES("images/"), 
	PATH_IMAGES_LOGO("images/logos/");
	
    
    private final String fileSaverPath;
    
    private FileSaverPath(String fileSaverPath){
        this.fileSaverPath = fileSaverPath;
    }

    public String getfileSaverPath() {
        return fileSaverPath;
    }
}
