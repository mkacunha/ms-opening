package br.com.gft.wa.manager.service.bench;

import java.util.Objects;

public class BenchLanguage {

    private String language;

    private String level;

    public BenchLanguage(String language, String level) {
        this.language = language;
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BenchLanguage that = (BenchLanguage) o;
        return Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language);
    }

    public String concatenated() {
        return language.concat(level).toLowerCase();
    }
}
