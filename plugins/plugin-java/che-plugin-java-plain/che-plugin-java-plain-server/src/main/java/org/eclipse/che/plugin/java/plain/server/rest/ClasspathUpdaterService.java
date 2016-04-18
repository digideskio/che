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
package org.eclipse.che.plugin.java.plain.server.rest;

import org.eclipse.che.ide.ext.java.shared.dto.classpath.ClasspathEntry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JavaModel;
import org.eclipse.jdt.internal.core.JavaModelManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Service for updating classpath.
 *
 * @author Valeriy Svydenko
 */
@Path("jdt/{wsId}/classpath/update")
public class ClasspathUpdaterService {
    private static final JavaModel model = JavaModelManager.getJavaModelManager().getJavaModel();

    /**
     * Updates the information about classpath.
     *
     * @param projectPath
     *         path to the current project
     * @param entries
     *         list of classpath entries which need to set
     * @throws JavaModelException
     *         when JavaModel has a failure
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateClasspath(@QueryParam("projectpath") String projectPath, List<ClasspathEntry> entries) throws JavaModelException {
        IJavaProject javaProject = model.getJavaProject(projectPath);

        javaProject.setRawClasspath(createModifiedEntry(entries), new NullProgressMonitor());
    }

    private IClasspathEntry[] createModifiedEntry(List<ClasspathEntry> entries) {
        IClasspathEntry[] coreClasspathEntries = new IClasspathEntry[entries.size()];
        int i = 0;
        for (ClasspathEntry entry : entries) {
            IPath path = org.eclipse.core.runtime.Path.fromOSString(entry.getPath());
            int entryKind = entry.getEntryKind();
            if (IClasspathEntry.CPE_LIBRARY == entryKind) {
                coreClasspathEntries[i] = JavaCore.newLibraryEntry(path, null, null);
            } else if (IClasspathEntry.CPE_SOURCE == entryKind) {
                coreClasspathEntries[i] = JavaCore.newSourceEntry(path);
            } else if (IClasspathEntry.CPE_VARIABLE == entryKind) {
                coreClasspathEntries[i] = JavaCore.newVariableEntry(path, null, null);
            } else if (IClasspathEntry.CPE_CONTAINER == entryKind) {
                coreClasspathEntries[i] = JavaCore.newContainerEntry(path);
            } else if (IClasspathEntry.CPE_PROJECT == entryKind) {
                coreClasspathEntries[i] = JavaCore.newProjectEntry(path);
            }
            i++;
        }
        return coreClasspathEntries;
    }
}
