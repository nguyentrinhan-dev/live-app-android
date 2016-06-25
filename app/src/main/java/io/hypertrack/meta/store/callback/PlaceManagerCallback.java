package io.hypertrack.meta.store.callback;

import io.hypertrack.meta.model.MetaPlace;

/**
 * Created by ulhas on 21/06/16.
 */
public abstract class PlaceManagerCallback {
    public abstract void OnSuccess(MetaPlace place);
    public abstract void OnError();
}
