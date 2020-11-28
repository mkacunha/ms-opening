package br.com.gft.wa.manager.service.bench;

class BenchResultSet {

    String name;

    String id;

    String status;

    String family;

    String level;

    String city;

    String location;

    String skill;

    String skillLevel;

    String language;

    String languageLevel;

    public Bench toBench() {
        return new Bench(
                name,
                id,
                status,
                family,
                level,
                city,
                location
        );
    }
}
