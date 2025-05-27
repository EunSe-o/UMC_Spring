package umc.spring.domain;
public enum MissionStatus {
    new_, completed, progress;
    @Override
    public String toString() {
        return this.name().equals("new_") ? "new" : this.name();
    }
}