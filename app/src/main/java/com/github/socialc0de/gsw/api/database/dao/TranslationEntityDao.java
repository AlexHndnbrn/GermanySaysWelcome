package com.github.socialc0de.gsw.api.database.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.github.socialc0de.gsw.api.database.entity.TranslationEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TranslationEntity".
*/
public class TranslationEntityDao extends AbstractDao<TranslationEntity, Long> {

    public static final String TABLENAME = "TranslationEntity";

    /**
     * Properties of entity TranslationEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property DID = new Property(1, String.class, "DID", false, "DID");
        public final static Property Language_code = new Property(2, String.class, "language_code", false, "LANGUAGE_CODE");
        public final static Property Name = new Property(3, String.class, "name", false, "NAME");
        public final static Property Description = new Property(4, String.class, "description", false, "DESCRIPTION");
        public final static Property Question = new Property(5, String.class, "question", false, "QUESTION");
        public final static Property Answer = new Property(6, String.class, "answer", false, "ANSWER");
        public final static Property Phrase = new Property(7, String.class, "phrase", false, "PHRASE");
        public final static Property TranslationID = new Property(8, long.class, "translationID", false, "TRANSLATION_ID");
    };

    private Query<TranslationEntity> audienceEntry_TranslationsQuery;
    private Query<TranslationEntity> phraseCategory_TranslationsQuery;

    public TranslationEntityDao(DaoConfig config) {
        super(config);
    }
    
    public TranslationEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TranslationEntity\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"DID\" TEXT," + // 1: DID
                "\"LANGUAGE_CODE\" TEXT," + // 2: language_code
                "\"NAME\" TEXT," + // 3: name
                "\"DESCRIPTION\" TEXT," + // 4: description
                "\"QUESTION\" TEXT," + // 5: question
                "\"ANSWER\" TEXT," + // 6: answer
                "\"PHRASE\" TEXT," + // 7: phrase
                "\"TRANSLATION_ID\" INTEGER NOT NULL );"); // 8: translationID
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TranslationEntity\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, TranslationEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String DID = entity.getDID();
        if (DID != null) {
            stmt.bindString(2, DID);
        }
 
        String language_code = entity.getLanguage_code();
        if (language_code != null) {
            stmt.bindString(3, language_code);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(5, description);
        }
 
        String question = entity.getQuestion();
        if (question != null) {
            stmt.bindString(6, question);
        }
 
        String answer = entity.getAnswer();
        if (answer != null) {
            stmt.bindString(7, answer);
        }
 
        String phrase = entity.getPhrase();
        if (phrase != null) {
            stmt.bindString(8, phrase);
        }
        stmt.bindLong(9, entity.getTranslationID());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public TranslationEntity readEntity(Cursor cursor, int offset) {
        TranslationEntity entity = new TranslationEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // DID
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // language_code
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // description
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // question
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // answer
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // phrase
            cursor.getLong(offset + 8) // translationID
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, TranslationEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDID(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLanguage_code(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDescription(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setQuestion(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAnswer(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPhrase(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setTranslationID(cursor.getLong(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(TranslationEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(TranslationEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "translations" to-many relationship of AudienceEntry. */
    public List<TranslationEntity> _queryAudienceEntry_Translations(long translationID) {
        synchronized (this) {
            if (audienceEntry_TranslationsQuery == null) {
                QueryBuilder<TranslationEntity> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.TranslationID.eq(null));
                audienceEntry_TranslationsQuery = queryBuilder.build();
            }
        }
        Query<TranslationEntity> query = audienceEntry_TranslationsQuery.forCurrentThread();
        query.setParameter(0, translationID);
        return query.list();
    }

    /** Internal query to resolve the "translations" to-many relationship of PhraseCategory. */
    public List<TranslationEntity> _queryPhraseCategory_Translations(long translationID) {
        synchronized (this) {
            if (phraseCategory_TranslationsQuery == null) {
                QueryBuilder<TranslationEntity> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.TranslationID.eq(null));
                phraseCategory_TranslationsQuery = queryBuilder.build();
            }
        }
        Query<TranslationEntity> query = phraseCategory_TranslationsQuery.forCurrentThread();
        query.setParameter(0, translationID);
        return query.list();
    }

}
