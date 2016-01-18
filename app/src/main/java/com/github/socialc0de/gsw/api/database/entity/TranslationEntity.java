package com.github.socialc0de.gsw.api.database.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "TranslationEntity".
 */
public class TranslationEntity {

    private Long id;
    private String DID;
    private String language_code;
    private String name;
    private String description;
    private String question;
    private String answer;
    private String phrase;
    private long translationID;

    public TranslationEntity() {
    }

    public TranslationEntity(Long id) {
        this.id = id;
    }

    public TranslationEntity(Long id, String DID, String language_code, String name, String description, String question, String answer, String phrase, long translationID) {
        this.id = id;
        this.DID = DID;
        this.language_code = language_code;
        this.name = name;
        this.description = description;
        this.question = question;
        this.answer = answer;
        this.phrase = phrase;
        this.translationID = translationID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public long getTranslationID() {
        return translationID;
    }

    public void setTranslationID(long translationID) {
        this.translationID = translationID;
    }

}
