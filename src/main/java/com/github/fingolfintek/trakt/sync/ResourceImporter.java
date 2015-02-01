package com.github.fingolfintek.trakt.sync;

import java.io.IOException;

import com.github.fingolfintek.trakt.api.model.sync.SyncResult;
import org.springframework.core.io.Resource;

public interface ResourceImporter {

    SyncResult importFrom(Resource resource) throws IOException;
}
