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
 * Arguments holder for {@link org.eclipse.che.plugin.docker.client.DockerConnector#killContainer(KillContainerParams)}.
 *
 * @author Mykola Morhun
 */
public class KillContainerParams {

    private String  container;
    private Integer signal;

    /**
     * Creates arguments holder with required parameters.
     *
     * @param container
     *         info about this parameter see {@link #withContainer(String)}
     * @return arguments holder with required parameters
     */
    public static KillContainerParams from(@NotNull String container) {
        return new KillContainerParams().withContainer(container);
    }

    private KillContainerParams() {}

    /**
     * @param container
     *         container identifier, either id or name
     */
    public KillContainerParams withContainer(@NotNull String container) {
        requireNonNull(container);
        this.container = container;
        return this;
    }

    /**
     * @param signal
     *         code of signal, e.g. 9 in case of SIGKILL
     */
    public KillContainerParams withSignal(int signal) {
        this.signal = signal;
        return this;
    }

    public String container() {
        return container;
    }

    public Integer signal() {
        return signal;
    }

}
