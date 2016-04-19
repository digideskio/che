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
 * Arguments holder for {@link org.eclipse.che.plugin.docker.client.DockerConnector#removeContainer(RemoveContainerParams)}.
 *
 * @author Mykola Morhun
 */
public class RemoveContainerParams {

    private String  container;
    private Boolean force;
    private Boolean removeVolumes;

    /**
     * Creates arguments holder with required parameters.
     *
     * @param container
     *         info about this parameter see {@link #withContainer(String)}
     * @return arguments holder with required parameters
     */
    public static RemoveContainerParams from(@NotNull String container) {
        return new RemoveContainerParams().withContainer(container);
    }

    private RemoveContainerParams() {}

    /**
     * @param container
     *         container identifier, either id or name
     */
    public RemoveContainerParams withContainer(@NotNull String container) {
        requireNonNull(container);
        this.container = container;
        return this;
    }

    /**
     * @param force
     *         if {@code true} kills the running container then remove it
     */
    public RemoveContainerParams withForce(boolean force) {
        this.force = force;
        return this;
    }

    /**
     * @param removeVolumes
     *         if {@code true} removes volumes associated to the container
     */
    public RemoveContainerParams withRemoveVolumes(boolean removeVolumes) {
        this.removeVolumes = removeVolumes;
        return this;
    }

    public String container() {
        return container;
    }

    public Boolean force() {
        return force;
    }

    public Boolean removeVolumes() {
        return removeVolumes;
    }

}
