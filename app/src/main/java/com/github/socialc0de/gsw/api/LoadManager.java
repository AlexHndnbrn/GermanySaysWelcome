package com.github.socialc0de.gsw.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.github.socialc0de.gsw.activities.MainActivity;
import com.github.socialc0de.gsw.api.interfaces.AudienceRestClient;
import com.github.socialc0de.gsw.api.interfaces.EmergencyEntryRestClient;
import com.github.socialc0de.gsw.api.interfaces.FaqCategoryRestClient;
import com.github.socialc0de.gsw.api.interfaces.FaqEntryRestClient;
import com.github.socialc0de.gsw.api.interfaces.PhraseCategoryRestClient;
import com.github.socialc0de.gsw.api.interfaces.PhraseEntryRestClient;
import com.github.socialc0de.gsw.api.interfaces.PoiCategoryRestClient;
import com.github.socialc0de.gsw.api.interfaces.PoiEntryRestClient;
import com.github.socialc0de.gsw.api.interfaces.RestArrayRequestCallBack;
import com.github.socialc0de.gsw.customClasses.api.AudienceEntry;
import com.github.socialc0de.gsw.customClasses.api.EmergencyEntry;
import com.github.socialc0de.gsw.customClasses.api.FaqCategory;
import com.github.socialc0de.gsw.customClasses.api.FaqEntry;
import com.github.socialc0de.gsw.customClasses.api.PhraseCategory;
import com.github.socialc0de.gsw.customClasses.api.PhraseEntry;
import com.github.socialc0de.gsw.customClasses.api.PoiCategory;
import com.github.socialc0de.gsw.customClasses.api.PoiEntry;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.springframework.core.NestedRuntimeException;

import java.util.ArrayList;

/**
 * Created by roman on 05.12.2015.
 */

@EBean(scope = EBean.Scope.Singleton)
public class LoadManager implements org.androidannotations.api.rest.RestErrorHandler {
    public static final int NETWORK_NOT_AVAILABLE = 0;
    public static final int NETWORK_AVAILABLE = 1;
    public static final int NETWORK_MISC = 2;
    public static final int NETWORK_SERVICE_NOT_AVAILABLE = 3;

    private Context mCurrentActivity = null;
    private RestArrayRequestCallBack mCallback = null;

    private int mNetworkstate = NETWORK_AVAILABLE;

    @AfterInject
    protected void afterInject() {

    }

    /**
     * Loads infos and warnings results
     *
     * @param callback - callback is called after response with result and networt state (NETWORK_NOT_AVAILABLE or NETWORK_AVAILABLE)
     */

    @Background
    public void loadFaqCategoryResults(final RestArrayRequestCallBack callback) {
        FaqCategoryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createFaqCategoryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<FaqCategory> results = mRestClient.loadFaqCategoryFromRest();
            if (results == null)
                results = new ArrayList<FaqCategory>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    @Background
    public void loadPhraseCategoryResults(final RestArrayRequestCallBack callback) {
        PhraseCategoryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createPhraseCategoryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<PhraseCategory> results = mRestClient.loadPhraseCategoryFromRest();
            if (results == null)
                results = new ArrayList<PhraseCategory>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    @Background
    public void loadPoiCategoryResults(final RestArrayRequestCallBack callback) {
        PoiCategoryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createPoiCategoryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<PoiCategory> results = mRestClient.loadPoiCategoryFromRest();
            if (results == null)
                results = new ArrayList<PoiCategory>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    @Background
    public void loadAudienceResults(final RestArrayRequestCallBack callback) {
        AudienceRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createAudienceRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<AudienceEntry> results = mRestClient.loadAudienceFromRest();
            if (results == null)
                results = new ArrayList<AudienceEntry>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    @Background
    public void loadFaqEntriesByCategoryResults(final RestArrayRequestCallBack callback, int category) {
        FaqEntryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createFaqEntryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<FaqEntry> results = mRestClient.loadFaqEntriesByCategoryFromRest(category);
            if (results == null)
                results = new ArrayList<FaqEntry>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    @Background
    public void loadFaqEntriesByAudienceResults(final RestArrayRequestCallBack callback, int audience) {
        FaqEntryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createFaqEntryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<FaqEntry> results = mRestClient.loadFaqEntriesByAudienceFromRest(audience);
            if (results == null)
                results = new ArrayList<FaqEntry>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    @Background
    public void loadFaqEntriesResults(final RestArrayRequestCallBack callback) {
        FaqEntryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createFaqEntryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<FaqEntry> results = mRestClient.loadFaqEntriesFromRest();
            if (results == null)
                results = new ArrayList<FaqEntry>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    @Background
    public void addFaqEntry(FaqEntry faqEntry) {
        FaqEntryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;

        mRestClient = RestClientHelper.createFaqEntryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
        } else {
            faqEntry.getTranslations().postFormat();
            mRestClient.addFaqEntry(faqEntry);
        }
    }

    @Background
    public void loadPoiEntriesResults(final RestArrayRequestCallBack callback) {
        PoiEntryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createPoiEntryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<PoiEntry> results = mRestClient.loadPoiEntriesFromRest();
            if (results == null)
                results = new ArrayList<PoiEntry>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    @Background
    public void loadPoiEntriesByCategoryResults(final RestArrayRequestCallBack callback, int category) {
        PoiEntryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createPoiEntryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<PoiEntry> results = mRestClient.loadPoiEntriesByCategoryFromRest(category);
            if (results == null)
                results = new ArrayList<PoiEntry>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }


    @Background
    public void loadPoiEntriesByCategoryAndBBoxResults(final RestArrayRequestCallBack callback, int category, float minLat, float minLng, float maxLat, float maxLng) {
        PoiEntryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createPoiEntryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<PoiEntry> results = mRestClient.loadPoiEntriesByCategoryAndBBoxFromRest(category, minLat, minLng, maxLat, maxLng);
            if (results == null)
                results = new ArrayList<PoiEntry>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }


    @Background
    public void loadPhraseEntriesResults(final RestArrayRequestCallBack callback) {
        PhraseEntryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createPhraseEntryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<PhraseEntry> results = mRestClient.loadPhraseEntriesFromRest();
            if (results == null)
                results = new ArrayList<PhraseEntry>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    @Background
    public void loadPhraseEntriesByCategoryResults(final RestArrayRequestCallBack callback, int category) {
        PhraseEntryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createPhraseEntryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<PhraseEntry> results = mRestClient.loadPhraseEntriesByCategoryFromRest(category);
            if (results == null)
                results = new ArrayList<PhraseEntry>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    @Background
    public void loadEmergencyEntriesResults(final RestArrayRequestCallBack callback) {
        EmergencyEntryRestClient mRestClient;
        mNetworkstate = NETWORK_AVAILABLE;


        if (callback == null) {
            return;
        }
        mCallback = callback; // store callback class for error

        mRestClient = RestClientHelper.createEmergencyEntryRestClientWithTimeout(getCurrentActivity());//new CurrencyRestClient_(getCurrentActivity());
        mRestClient.setRestErrorHandler(this);

        Boolean networkAvailable = checkNetworkState();
        if (networkAvailable == null) {
            return;
        }

        if (!networkAvailable) {
            mNetworkstate = NETWORK_NOT_AVAILABLE;
            callback.onRestResults(mNetworkstate, null);
        } else {
            ArrayList<EmergencyEntry> results = mRestClient.loadEmergencyEntriesFromRest();
            if (results == null)
                results = new ArrayList<EmergencyEntry>();

            if (mNetworkstate == NETWORK_AVAILABLE) {
                if (callback != null && !callback.isDestroyed()) {
                    callback.onRestResults(mNetworkstate, results);
                }
            }
        }
    }

    private Context getCurrentActivity() {
        return this.mCurrentActivity;
    }

    public void setCurrentActivity(Context currentActivity) {
        this.mCurrentActivity = currentActivity;
    }

    /**
     * Check network state. Returns true, if network connected
     *
     * @return true, if connected
     */
    private Boolean checkNetworkState() {

        ConnectivityManager connectivityManager = (ConnectivityManager) MainActivity.getMainActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }


    @Override
    public void onRestClientExceptionThrown(NestedRuntimeException e) {
        //BackgroundExecutor.cancelAll("cancellable_task", true);
        mNetworkstate = NETWORK_MISC;
        if (mCallback != null && !mCallback.isDestroyed()) {
            mCallback.onRestResults(mNetworkstate, null);
        }
    }


}

