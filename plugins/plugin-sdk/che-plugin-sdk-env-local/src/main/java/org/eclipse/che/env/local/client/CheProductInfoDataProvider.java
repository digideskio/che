/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.env.local.client;

import org.eclipse.che.ide.api.ProductInfoDataProvider;
import org.eclipse.che.ide.ui.Resources;
import org.vectomatic.dom.svg.ui.SVGResource;

import javax.inject.Inject;

/**
 * Implementation of {@link ProductInfoDataProvider}
 *
 * @author Alexander Andrienko
 */
public class CheProductInfoDataProvider implements ProductInfoDataProvider {

    private final LocalizationConstant locale;
    private final Resources            resources;

    @Inject
    public CheProductInfoDataProvider(LocalizationConstant locale, Resources resources) {
        this.locale = locale;
        this.resources = resources;
    }

    @Override
    public String getName() {
        return locale.getProductName();
    }

    public String getSupportLink() {
        return locale.getSupportLink();
    }

    public String getDocumentTitle() {
        return locale.cheTabTitle();
    }

    public String getDocumentTitle(String workspaceName) {
        return locale.cheTabTitle(workspaceName);
    }

    public SVGResource getLogo() {
        return resources.logo();
    }

    @Override
    public String getSupportTitle() {
        return locale.supportTitle();
    }
}
