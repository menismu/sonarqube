/*
 * SonarQube
 * Copyright (C) 2009-2019 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.server.platform.db.migration.version.v77;

import org.sonar.server.platform.db.migration.step.MigrationStepRegistry;
import org.sonar.server.platform.db.migration.version.DbVersion;

public class DbVersion77 implements DbVersion {

  @Override
  public void addSteps(MigrationStepRegistry registry) {
    registry
      .add(2600, "Drop elasticsearch index 'tests'", DropElasticsearchIndexTests.class)
      .add(2601, "Delete lines with DATA_TYPE='TEST' from table FILES_SOURCE", DeleteTestDataTypeFromFileSources.class)
      .add(2602, "Add column LAST_CONNECTION_DATE to USERS table", AddLastConnectionDateToUsers.class)
      .add(2603, "Add column LAST_USED_DATE to USER_TOKENS table", AddLastConnectionDateToUserTokens.class)
      .add(2604, "Add baseline columns in PROJECT_BRANCHES", AddManualBaselineToProjectBranches.class)
      .add(2605, "Add SNAPSHOTS.PROJECT_VERSION", AddProjectVersionToSnapshot.class)

    ;
  }
}
