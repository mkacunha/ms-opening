package br.com.gft.wa.manager.service.bench;

import java.util.Objects;

public class BenchSkill {

    private String skill;

    private String level;

    public BenchSkill(String skill, String level) {
        this.skill = skill;
        this.level = level;
    }

    public String getSkill() {
        return skill;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BenchSkill that = (BenchSkill) o;
        return Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill);
    }

    public String concatenated() {
        return skill.concat(level).toLowerCase();
    }
}
