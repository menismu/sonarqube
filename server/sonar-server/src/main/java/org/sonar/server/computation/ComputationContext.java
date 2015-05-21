/*
 * SonarQube, open source software quality management tool.
 * Copyright (C) 2008-2014 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * SonarQube is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SonarQube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package org.sonar.server.computation;

import org.sonar.api.config.Settings;
import org.sonar.batch.protocol.output.BatchReport;
import org.sonar.batch.protocol.output.BatchReportReader;

public class ComputationContext {

  private final BatchReportReader reportReader;
  // Project key (including branch if any)
  private final String projectKey;
  // cache of metadata as it's frequently accessed
  private final BatchReport.Metadata reportMetadata;
  private final Settings projectSettings;

  public ComputationContext(BatchReportReader reportReader, String projectKey, Settings projectSettings) {
    this.reportReader = reportReader;
    this.projectKey = projectKey;
    this.projectSettings = projectSettings;
    this.reportMetadata = reportReader.readMetadata();
  }

  public BatchReport.Metadata getReportMetadata() {
    return reportMetadata;
  }

  public String getProjectKey() {
    return projectKey;
  }

  public BatchReportReader getReportReader() {
    return reportReader;
  }

  public Settings getProjectSettings() {
    return projectSettings;
  }

}
