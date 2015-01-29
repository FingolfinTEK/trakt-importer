package com.github.fingolfintek.trakt.sync;

import java.io.IOException;

import com.github.fingolfintek.trakt.api.model.sync.SyncResponse;
import org.springframework.core.io.Resource;

public interface ResourceImporter {
    
    SyncResponse importFrom(Resource resource) throws IOException;
}
