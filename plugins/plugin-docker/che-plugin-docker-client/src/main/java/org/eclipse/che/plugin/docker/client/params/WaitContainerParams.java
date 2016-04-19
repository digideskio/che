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
package org.eclipse.che.plugin.docker.client.params;

import javax.validation.constraints.NotNull;

import static java.util.Objects.requireNonNull;

/**
 * Arguments holder for {@link org.eclipse.che.plugin.docker.client.DockerConnector#waitContainer(WaitContainerParams)}.
 *
 * @author Mykola Morhun
 */
public class WaitContainerParams {

    private String container;

    /**
     * Creates arguments holder with required parameters.
     *
     * @param container
     *         info about this parameter see {@link #withContainer(String)}
     * @return arguments holder with required parameters
     */
    public static WaitContainerParams from(@NotNull String container) {
        return new WaitContainerParams().withContainer(container);
    }

    private WaitContainerParams() {}

    /**
     * @param container
     *         container identifier, either id or name
     */
    public WaitContainerParams withContainer(@NotNull String container) {
        requireNonNull(container);
        this.container = container;
        return this;
    }

    public String container() {
        return container;
    }

}
