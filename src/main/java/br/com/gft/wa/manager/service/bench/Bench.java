package br.com.gft.wa.manager.service.bench;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Bench {

    String name;

    String id;

    String status;

    String family;

    String level;

    String city;

    String location;

    private List<BenchSkill> skills = new ArrayList<>();

    private List<BenchLanguage> languages = new ArrayList<>();

    public Bench(String name, String id, String status, String family, String level, String city, String location) {
        this.name = name;
        this.id = id;
        this.status = status;
        this.family = family;
        this.level = level;
        this.city = city;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getFamily() {
        return family;
    }

    public String getLevel() {
        return level;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }

    public List<BenchSkill> getSkills() {
        return skills;
    }

    public List<BenchLanguage> getLanguages() {
        return languages;
    }

    public void applySkillAndLanguage(List<BenchResultSet> value) {
        value.stream().forEach(bench -> {
            if (bench.language != null && languages.stream().noneMatch(language -> language.getLanguage().equals(bench.language))) {
                languages.add(new BenchLanguage(bench.language, bench.languageLevel));
            }

            if (bench.skill != null && skills.stream().noneMatch(skill -> skill.getSkill().equals(bench.skill))) {
                skills.add(new BenchSkill(bench.skill, bench.skillLevel));
            }
        });
    }

    public boolean test(String filter) {
        String skills = this.skills.stream().map(BenchSkill::concatenated).collect(Collectors.joining());
        String languages = this.languages.stream().map(BenchLanguage::concatenated).collect(Collectors.joining());
        String value = new ConcatBuilder()
                .append(status)
                .append(family)
                .append(level)
                .append(city)
                .append(location)
                .append(skills)
                .append(languages)
                .build();
        return value.contains(filter.toLowerCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bench that = (Bench) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(id, that.id) &&
                Objects.equals(status, that.status) &&
                Objects.equals(family, that.family) &&
                Objects.equals(level, that.level) &&
                Objects.equals(city, that.city) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, status, family, level, city, location);
    }

    private static class ConcatBuilder {

        private StringBuilder stringBuilder = new StringBuilder();

        ConcatBuilder append(String value) {
            if (StringUtils.hasText(value)) {
                stringBuilder.append(value.toLowerCase().trim());
            }
            return this;
        }

        String build() {
            return stringBuilder.toString();
        }
    }
}
